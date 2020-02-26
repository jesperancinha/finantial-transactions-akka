package org.jesperancinha.portuguese.recipes.peixinhos

import org.joda.time.DateTime

object TaskSimulator {

  def waitMilliseconds(name: String, millisecondsTimes10: Long): Unit = {
    var i = 0
    while ( {
      i < millisecondsTimes10
    }) {
      try Thread.sleep(10)
      catch {
        case e: InterruptedException =>
          e.printStackTrace()
      }
      System.out.println(String.format("%s, 1, %s", name, DateTime.now.toString))

      i += 1
    }
  }
}
