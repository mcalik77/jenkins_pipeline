node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: 'Mustafa', description: 'paste your name', name: 'NAME', trim: true)]), pipelineTriggers([cron('* * * * *')])])
        sh "echo Hello ${NAME}"
        

    }
}