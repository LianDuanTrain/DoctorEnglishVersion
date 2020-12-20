# Docker Nework
##  Type:
        bridge
        host
        overlay
        macvlan
        none       
##  Commands:  
###     Default Bridge
            Docker Network Image - http://img.scoop.it/bmExZyvGWidultcwx9hCb7nTzqrqzN7Y9aBZTaXoQ8Q=
            docker network ls
            docker network inspect bridge
            docker run -itd --rm --name=alpine1 alpine 
            docker run -itd --rm --name=alpine2 alpine
            docker exec -it alpine1 /bin/sh
            docker exec -it alpine2 /bin/sh
            ping ip
            ping {containerName}       
            cat /etc/hosts
            cat /etc/resolv.conf 
            docker container stop alpine1   
            docker container stop alpine2
###     Create a Bridge
            docker network create --driver bridge alpine-net
            docker network inspect alpine-net
            docker run -itd --rm --name=apline1 --network=alpine-net alpine
            docker run -itd --rm --name=apline2 --network=alpine-net alpine
            docker network inspect alpine-net
            docker container attach  apline1  
            docker container attach  apline2
            ping ip
            ping {containerName}  
            cat /etc/hosts
            cat /etc/resolv.conf 
            docker network disconnect bridge alpine1
            docker network disconnect bridge alpine2
            docker network rm alpine-net


     






   




