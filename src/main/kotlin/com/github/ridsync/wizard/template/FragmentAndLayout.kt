package com.github.ridsync.wizard.template

import android.databinding.tool.ext.toCamelCase
import com.android.tools.idea.wizard.template.ProjectTemplateData

fun someActivity(
        packageName: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $packageName

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import ${projectData.applicationPackage}.R;

class ${entityName}sActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.${layoutName.toLowerCase()})
    }
}
"""
fun someActivityLayout(
        packageName: String,
        entityName: String) = """<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${packageName}.${entityName}sActivity">

</androidx.constraintlayout.widget.ConstraintLayout>
"""

fun someFragment(
        date: String,
        defaultPackage: String,
        newFilePackage: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
): String {
        val databindingName = "Fragment${entityName.toLowerCase().toCamelCase()}Binding"
        return """package $newFilePackage
        
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ${defaultPackage}.presentation.base.BaseAppBarFragment
import ${defaultPackage}.databinding.${databindingName}
import ${defaultPackage}.R

/**
 * Created by okwon on ${date}.
 * Description :
 */
@AndroidEntryPoint
class ${entityName}Fragment : BaseAppBarFragment<${databindingName}>(R.layout.${layoutName.toLowerCase()}) {

    private val viewModel by viewModels<${entityName}ViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fragment = this
        binding.viewModel = viewModel
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onInitViews() {}
    override fun onSubscribeVm() {}
    override fun onSetToolBarViews() {}

}

"""
}
fun someFragmentViewModel(
        date: String,
        defaultPackage: String,
        newFilePackage: String,
        entityName: String,
        layoutName: String,
        projectData: ProjectTemplateData
) = """package $newFilePackage

import ${defaultPackage}.core.DtkApplication
import ${defaultPackage}.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by okwon on ${date}.
 * Description :
 */
@HiltViewModel
class ${entityName}ViewModel @Inject constructor(
    private val application: DtkApplication
) : BaseViewModel(application) {

}
"""

fun someFragmentLayout(
        defaultPackage: String,
        newFilePackage: String,
        entityName: String) = """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="fragment"
            type="${newFilePackage}.${entityName}Fragment" />

        <variable
            name="viewModel"
            type="${newFilePackage}.${entityName}ViewModel" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""