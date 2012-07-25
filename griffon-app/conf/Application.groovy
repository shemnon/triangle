application {
    title = 'Triangle'
    startupGroups = ['triangle']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "triangle"
    'triangle' {
        model      = 'triangle.TriangleModel'
        view       = 'triangle.TriangleView'
        controller = 'triangle.TriangleController'
    }

}
