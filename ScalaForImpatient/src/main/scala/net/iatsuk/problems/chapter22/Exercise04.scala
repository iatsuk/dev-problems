package net.iatsuk.problems.chapter22

import java.awt._
import java.awt.event._

import javax.swing._

import scala.util.continuations._

object Exercise04 extends App {
  val frame = new JFrame()
  val button = new JButton("Next")
  setListener(button) { run() }
  val textField = new JTextArea(10, 40)
  textField.setEnabled(false)
  val label = new JLabel("Welcome to the demo app")
  frame.add(label, BorderLayout.NORTH)
  frame.add(textField)
  val panel = new JPanel()
  panel.add(button)
  frame.add(panel, BorderLayout.SOUTH)
  frame.pack()
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setVisible(true)

  def run(): Unit @suspendable = {
    val response1 = getResponce("What is your first name?")
    val response2 = getResponce("What is your last name?")
    process(response1, response2)
  }

  def process(s1: String, s2: String): Unit = {
    label.setText(s"Hello, $s1 $s2")
  }

  var cont: Unit => Unit = null

  def getResponce(promt: String): String @suspendable = {
    label.setText(promt)
    textField.setText("")
    textField.setEnabled(true)
    setListener(button) { cont() }
    shift {
      k: (Unit => Unit) => {
        cont = k
      }
    }
    setListener(button) { }
    val result = textField.getText
    textField.setEnabled(false)
    result
  }

  def setListener(button: JButton)(action: => Unit @suspendable): Unit = {
    for (l <- button.getActionListeners) button.removeActionListener(l)
    button.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent) { reset { action }; () }
    })
  }
}
