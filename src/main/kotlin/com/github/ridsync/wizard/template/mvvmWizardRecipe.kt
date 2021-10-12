package com.github.ridsync.wizard.template

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun RecipeExecutor.mvvmSetup(
    moduleData: ModuleTemplateData,
    defaultPackage: String,
    newFilePackage: String,
    entityName: String,
    layoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)
    val format = SimpleDateFormat("yyyy/MM/dd")
    val date = format.format(Date())

    val path = srcOut.absolutePath.replace("java","kotlin")
    val srcKotlinDir = File(path)
    save(
        someFragment(date, defaultPackage, newFilePackage, entityName, layoutName, projectData),
        srcKotlinDir.resolve("${entityName}Fragment.kt")
    )
    save(someFragmentViewModel(date, defaultPackage, newFilePackage, entityName, layoutName, projectData),
        srcKotlinDir.resolve("${entityName}ViewModel.kt"))
    save(someFragmentLayout(defaultPackage, newFilePackage, entityName),
        resOut.resolve("layout/$layoutName.xml")
    )
//    save(
//        someActivity(packageName, entityName, layoutName, projectData),
//        srcOut.resolve("$activityClass.kt")
//    )
//    save(someActivityLayout(packageName, entityName),
//        resOut.resolve("layout/$layoutName.xml")
//    )

}