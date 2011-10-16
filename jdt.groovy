//@GrabResolver(name='sven-local', root='file://localhost/home/sven/se/sweng/_github/svene/svene.github.com/maven2/releases')
@GrabResolver(name='sven-github', root='http://svene.github.com/maven2/releases')
@Grapes([
	@Grab(group='org.svenehrke', module='dt_java', version='0.0.1')
])
import org.svenehrke.dt.java.SimpleJavaDTDefinition
import org.svenehrke.dt.java.SimpleSwingDTDefinition
import org.svenehrke.dt.java.GradleDTDefinition

Map templates = [
    'simplejava' : new SimpleJavaDTDefinition(),
    'simpleswing' : new SimpleSwingDTDefinition(),
    'gradle' : new GradleDTDefinition()
]

if (!args) {
	printUsage(templates)
}
String key = args[0]
if (!templates.keySet().contains(key)) {
	printUsage()
}

templates[key].createTargetFolder()

def printUsage(Map aTemplates) {
	println 'Usage: groovy J.groovy ' + aTemplates.keySet().join(' | ')
	System.exit(1)
}









