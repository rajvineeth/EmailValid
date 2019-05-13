node{




    stage('setup'){
			sh 'apk update'
            sh 'apk add sudo '
			sh 'sudo apk update; sudo apk add  curl '
			//  sh 'sudo curl -L https://github.com/docker/compose/releases/download/1.18.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose'
			//  sh 'sudo curl -L https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose'

            sh 'sudo apk add docker'
            //;sudo apk add docker-compose'
        
            sh 'sudo apk add --update docker'
            sh  'apk update'
            sh 'sudo apk add  python-dev;sudo apk add  libffi-dev;sudo apk add  openssl-dev; sudo apk add gcc;sudo apk add  libc-dev;sudo apk add make'
            sh 'apk add py-pip'
            //sh 'apk add docker
            sh 'pwd'
            sh 'pip install docker-compose'
            sh 'echo $PATH'
            sh 'which docker-compose'
			// sh 'pip show --files docker-compose'
			// sh 'export PATH=`/usr/local/bin:$PATH`'
			// sh 'sudo curl -L `https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)` -o /usr/local/bin/docker-compose'
			// sh 'sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose'
			// sh 'sudo `PATH=$PATH` docker-compose'
            // sh 'sudo `PATH=$PATH:/home/user/.local/bin` docker-compose'
            // sh 'sudo pip install -U docker-compose'
            // sh 'which docker-compose'
            // sh 'sudo chmod +x /usr/bin/docker-compose'
            sh 'docker-compose --version'
            sh 'pwd'
            // sh 'sudo apk add --update docker-compose'
            // sh 'sudo apk add --update pip'
            // sh 'sudo pip install docker-compose '
			// sh 'sudo chmod +x /usr/local/bin/docker-compose'
            // sh 'sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose'
            // 'sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose'
            // sh 'sudo `PATH=$PATH` docker-compose'
			//  sh 'sudo chown -R $(whoami) /usr/local/bin;sudo chmod +x /usr/local/bin/docker-compose'
			//  sh 'pip show --files docker-compose'
            sh 'set ff=unix'
			// sh 'sudo `PATH=$PATH:/home/user/.local/bin` docker-compose'
            // sh 'sudo "PATH=$PATH:/home/user/.local/bin" docker-compose'
            // sh 'sudo /usr/local/bin/docker-compose up --build'
            sh 'sudo pip install docker-compose'
            //sh  'export PATH=$HOME/.local/bin:$PATH'            
            sh 'which docker-compose'
            //sh 'docker kill $(docker ps -q)'
			
    }
    stage('SCM Checkout'){
        git credentialsId: 'ba17d94f-f0a5-453e-98ab-0a53f98fdc22', url: 'https://git.cgi.com/palash.moon/emailValidation.git'
    }
    
    stage('Mvn Package'){
        def mvnHome = tool name: 'Maven 3.6.0', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh "${mvnCMD} clean install"
    }
    stage('build') {
          sh 'docker-compose up --build'
    }        
}