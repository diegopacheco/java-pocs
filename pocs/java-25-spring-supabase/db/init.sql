CREATE SCHEMA IF NOT EXISTS auth;
CREATE SCHEMA IF NOT EXISTS realtime;
CREATE SCHEMA IF NOT EXISTS storage;
CREATE SCHEMA IF NOT EXISTS extensions;

-- Enable necessary extensions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create realtime tenants table
CREATE TABLE IF NOT EXISTS realtime.tenants (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    external_id text UNIQUE NOT NULL,
    name text,
    extensions jsonb DEFAULT '{}',
    jwt_secret text,
    max_events_per_second integer DEFAULT 100,
    inserted_at timestamptz DEFAULT NOW(),
    updated_at timestamptz DEFAULT NOW()
);

-- Insert default tenant
INSERT INTO realtime.tenants (external_id, name, jwt_secret, max_events_per_second)
VALUES ('supabase-realtime', 'supabase-realtime', 'super-secret-jwt-token-with-at-least-32-characters-long', 1000)
ON CONFLICT (external_id) DO NOTHING;

CREATE TABLE IF NOT EXISTS auth.users (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    email varchar(255) UNIQUE NOT NULL,
    created_at timestamp with time zone DEFAULT now()
);

CREATE TABLE IF NOT EXISTS votes (
    id SERIAL PRIMARY KEY,
    option_name VARCHAR(255) NOT NULL,
    vote_count INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO votes (option_name, vote_count) VALUES
('Option A', 0),
('Option B', 0),
('Option C', 0)
ON CONFLICT DO NOTHING;

CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_votes_updated_at BEFORE UPDATE ON votes
    FOR EACH ROW EXECUTE PROCEDURE update_updated_at_column();

-- Enable realtime for votes table
ALTER TABLE votes REPLICA IDENTITY FULL;
CREATE PUBLICATION supabase_realtime FOR TABLE votes;