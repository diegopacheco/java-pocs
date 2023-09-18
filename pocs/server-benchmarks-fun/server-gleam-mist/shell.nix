{pkgs, ...}:

pkgs.mkShell {
  buildInputs = with pkgs; [
    gleam
    rebar3
    erlang
  ];
}
