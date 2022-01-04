
println("Hello from DevOps")

"ls -la".execute().text

//или

new File('/etc/passwd').text

//(выводим все методы)
Jenkins.instance.metaClass.methods*.name
//(узнать число сборщиков)
Jenkins.instance.getNumExecutors()
//(установить число сборщиков)
Jenkins.instance.getNumExecutors(5)

//Вывести все результаты джоба

job = Jenkins.instance.getItemByFullName('Deploy-to-server_ub1_from_GitHub')

job.getBuilds().each {
   println('Build ' + it + ' Results ' + it.result)
}

//Стираем счетчик  успешных сборок

job = Jenkins.instance.getItemByFullName('NameJob')

job.getBuilds().each {
   if(it.result == RESULT.SUCCESS){
     it.delete()
   }
}

//Стираем счетчик  всех сборок

job.builds().each { build =>
     build.delete()
}
}

//Обнуляем, ставим желаемый следующий номер сборки

job.updateNextBuildNumber(1)
