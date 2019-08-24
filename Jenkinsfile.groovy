node {
    stage("Pull Repo"){
        properties([parameters([string(defaultValue: '18.212.102.68', description: '''Dev: 18.212.102.68 QA: 54.89.147.203 Prod: 52.72.201.180''', name: 'Remote_instances', trim: true)])])
        git 'https://github.com/mcalik77/jenkins.git'
    }
    stage("Install Apache") {
        sh "ssh ec2-user@${Remote_instances} sudo yum install httpd -y"
    }
    stage("Create index.html"){
        sh "scp index.html ec2-user@${Remote_instances}:/tmp"
    }
     stage("Move files"){
        sh "ssh ec2-user@${Remote_instances}  sudo mv /tmp/index.html /var/www/html/index.html"
    }
     stage("Restart httpd"){
        sh "ssh ec2-user@${Remote_instances}  sudo systemctl restart httpd"
    }
}
