package com.github.ridsync.androidmvvmplugintemplate.services

import com.intellij.openapi.project.Project
import com.github.ridsync.androidmvvmplugintemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
