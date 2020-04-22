provider "aws" {
  region = "us-east-1"
  access_key = "0"
  secret_key = "0"
  skip_credentials_validation = true
  skip_requesting_account_id = true
  skip_metadata_api_check = true
  s3_force_path_style = true
  # In order to Mock with Localstack
  endpoints {
    kms = "http://localhost:4566"
  }
}

# Importing an exising key
data "aws_kms_key" "mykey" {
  key_id = "010b31d6-676b-4cea-83c9-28a8375ca001"
}

# Generate a new Key
resource "aws_kms_key" "key2" {
  description             = "KMS key 2"
  deletion_window_in_days = 10
}

output "kms_key_key_created_details" {
  value = [
            "${aws_kms_key.key2.description}",
            "${aws_kms_key.key2.arn}",
            "${aws_kms_key.key2.key_id}",
           ]
}