#!/usr/bin/env bash
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/common.sh"

if ! resolve_java_home >/dev/null 2>&1; then
    if [ ! -s "$HOME/.sdkman/bin/sdkman-init.sh" ]; then
        echo "sdkman not found, install Java $JAVA_REQUIRED manually and set JAVA_HOME" >&2
        exit 1
    fi
    set +u
    . "$HOME/.sdkman/bin/sdkman-init.sh"
    set -u
    sdk install java "${JAVA_REQUIRED}.0.0-amzn" </dev/null
fi

require_java
echo "java: $("$JAVA_HOME/bin/java" -version 2>&1 | head -1)"

mvn_run -q test-compile
echo "setup complete"
