package com.github.ridsync.androidmvvmtemplate.services

import com.intellij.openapi.project.Project
import com.github.ridsync.androidmvvmtemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
