# Install Docker and Docker Compose on Oracle Linux 9
## Topics  
- Prerequisite
- Install Docker
- Configure Docker Run as A Non-root User
- Install Docker Compose

## Prerequisite
- OS version - Oracle Linux Server release 9.0
    - cat /etc/oracle-release
## Install Docker
Commands:
1. su - 
2. systemctl stop firewalld
3. systemctl disable firewalld
4. dnf update -y
5. dnf remove -y podman buildah  
6. dnf config-manager --add-repo=https://download.docker.com/linux/centos/docker-ce.repo
7. dnf install -y docker-ce 
8. systemctl enable docker.service
9. systemctl start docker.service
10. systemctl status docker.service
### Verify Docker
Commands:  
1.  docker info
2.  docker version
    
## Configure Docker Run as A Non-root User
Commands:   
1. usermod -aG docker lian
2. echo "lian  ALL=(ALL)  NOPASSWD: /usr/bin/docker" >> /etc/sudoers
3. echo "alias docker=\"sudo /usr/bin/docker\"" >> /home/lian/.bash_profile

### Verify Non-root User Run Docker   
Commands:   
1. source .bash_profile
2. docker ps   
3. docker run hello-world

## Install Docker Compose
Commands:
1. su -
2. dnf install -y docker-compose-plugin

### Verify Docker Compose
Commands:
1. docker compose version