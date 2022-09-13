# Install Docker and Docker Compose on Oracle Linux 8
## Topics  
- Prerequisite
- Install Docker
- Configure Docker Run as A Non-root User
- Install Docker Compose

## Prerequisite
- OS version - Oracle Linux Server release 8.6
    - cat /etc/oracle-release
## Install Docker
- systemctl stop firewalld
- systemctl disable firewalld
- dnf -y update
- dnf remove  podman buildah  
- dnf config-manager --add-repo=https://download.docker.com/linux/centos/docker-ce.repo
- dnf install -y docker-ce 
- systemctl enable docker.service
- systemctl start docker.service
- systemctl status docker.service
### Verify   
- docker info
- docker version
    
## Configure Docker Run as A Non-root User   
- groupadd docker
- usermod -aG docker lian
- echo "lian  ALL=(ALL)  NOPASSWD: /usr/bin/docker" >> /etc/sudoers
- echo "alias docker=\"sudo /usr/bin/docker\"" >> /home/lian/.bash_profile

### Verify       
- docker ps   
- docker run hello-world

## Install Docker Compose
- dnf install -y docker-compose-plugin

### Verify 
- docker compose version