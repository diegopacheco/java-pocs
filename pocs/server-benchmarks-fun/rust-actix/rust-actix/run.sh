#!/bin/bash

cargo build --release

ulimit -n 100000
ulimit -a

target/release/rust-actix