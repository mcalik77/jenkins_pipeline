node {
    stage("Say Hello"){
        properties([pipelineTriggers([cron('* * * * *')])])
        sh "echo Hello ${NAME}",
        sh "do something"

    }
}