package triangle

import javax.swing.JSlider
import static javax.swing.SwingConstants.VERTICAL
import static java.awt.GridBagConstraints.*

application(title: 'triangle',
        pack:true,
        locationByPlatform: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                imageIcon('/griffon-icon-32x32.png').image,
                imageIcon('/griffon-icon-16x16.png').image])
{
        panel(layout: gridBagLayout()) {
            slider(minimum: 1, maximum:10, value: bind(target:model, 'height', value: 8), orientation: VERTICAL,
                gridx:0, gridy: 0, fill: VERTICAL, weighty: 1.0
            )

            int step = 16
            canvas = canvas(gridx: 1, gridy: 0, fill:BOTH, weightx: 1.0) {

                group {
                    (0..10).each { n ->
                        line(borderWidth: 1, borderColor: 'black', x1:5, y1: 25+step*n, x2: 165, y2: 25+step*n)
                    }

                    (0..10).each { n ->
                        line(borderWidth: 1, borderColor: 'black', x1:5+n*step, y1: 25, x2: 5+n*step, y2: 185)
                    }

                    triangle(x: 5, y: 185, anglePosition: 0, fill: 'blue',
                            width: bind {model.width*step}, height: bind {model.height*step})
                }

            }
            model.propertyChange = { evt = null ->
                canvas.repaint()
            }

            slider(minimum: 1, maximum:10, value: bind(target: model, 'width', value: 6),
                    gridx:1, gridy: 1, fill: VERTICAL
            )

            hbox(gridx:0, gridy: 2, gridwidth: 2, fill: VERTICAL, insets: [3,6,3,6]) {
                label 'Width:'
                label(text: bind {model.width} )
            }

            hbox(gridx:0, gridy: 3, gridwidth: 2, fill: VERTICAL, insets: [3,6,3,6]) {
                label 'Height:'
                label (text: bind {model.height})
            }

            hbox(gridx:0, gridy: 4, gridwidth: 2, fill: VERTICAL, insets: [3,6,6,6]) {
                label 'Hypo:'
                label (text: bind {Math.sqrt(model.width*model.width + model.height*model.height)})
            }



    }
}
