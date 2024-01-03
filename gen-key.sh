#!/bin/bash
gpg --batch --gen-key gen-key-script
uid=$(gpg --list-secret-keys --with-colons | awk -F: '$1 == "sec" {print $5}')
gpg --keyserver keyserver.ubuntu.com --send-keys $uid
echo "waiting..."
sleep 90
echo "waiting finish!"
gpg --keyserver keyserver.ubuntu.com --recv-keys $uid