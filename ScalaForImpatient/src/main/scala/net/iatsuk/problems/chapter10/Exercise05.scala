package net.iatsuk.problems.chapter10

import java.awt.Point
import java.beans.{PropertyChangeEvent, PropertyChangeListener, PropertyChangeSupport}

trait PropertyChangeSupportLike {
  private[this] val support = new PropertyChangeSupport(this)

  def addPropertyChangeListener(listener: PropertyChangeListener): Unit = support.addPropertyChangeListener(listener)

  def removePropertyChangeListener(listener: PropertyChangeListener): Unit = support.removePropertyChangeListener(listener)

  def getPropertyChangeListeners: Array[PropertyChangeListener] = support.getPropertyChangeListeners()

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
    support.addPropertyChangeListener(propertyName, listener)
  }

  def removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener): Unit = {
    support.removePropertyChangeListener(propertyName, listener)
  }

  def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener] = {
    support.getPropertyChangeListeners(propertyName)
  }

  def firePropertyChange(propertyName: String, oldValue: Any, newValue: Any): Unit = {
    support.firePropertyChange(propertyName,oldValue, newValue)
  }

  def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int): Unit = {
    support.firePropertyChange(propertyName, oldValue, newValue)
  }

  def firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean): Unit = {
    support.firePropertyChange(propertyName, oldValue, newValue)
  }

  def firePropertyChange(event: PropertyChangeEvent): Unit = {
    support.firePropertyChange(event)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Any, newValue: Any): Unit = {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int): Unit = {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean): Unit = {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def hasListeners(propertyName: String): Boolean = support.hasListeners(propertyName)
}

object Exercise05 extends App {
  val p = new Point(0, 0) with PropertyChangeSupportLike
}
