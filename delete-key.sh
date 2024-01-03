#!/bin/bash
uid=$(gpg --list-secret-keys --with-colons | awk -F: '$1 == "sec" {print $5}')
gpg --delete-secret-key $id
gpg --delete-key $id