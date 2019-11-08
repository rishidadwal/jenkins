freeStyleJob('JOB_NAME') {
   steps {
    shell('ls')
  }
}

pipelineJob('studentapp-ci') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('git@github.com:rishidadwal/jenkins.git')
             'credentialsId'('1990rishi@gmail.com')
          }
        }

        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('pipeline-jobs/studentapp-ci.JenkinsFile')
      'lightweight'(true)
    }
  }
}