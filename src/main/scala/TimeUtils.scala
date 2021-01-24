object TimeUtils {
  val minutesInADay = 1440

  def addMinutes(timeString: String, minutes: Int): String = {
    val minutesToAdd = minutes % minutesInADay
    var result = (minutesSinceMidnight(timeString) + minutesToAdd) % minutesInADay
    minutesToString(if (result < 0) minutesInADay + result else result)
  }

  def minutesSinceMidnight(timeString: String): Int = {
    val colon = timeString.indexOf(":")
    val minutes = timeString.substring(colon + 1, colon + 3).toInt
    val ampm = timeString.takeRight(2)
    var hours = timeString.substring(0, colon).toInt

    if (ampm == "PM" && hours != 12)
      hours += 12

    hours * 60 + minutes
  }

  def minutesToString(minutesSinceMidnight: Int): String = {
    val ampm = if (minutesSinceMidnight < 720) "AM" else "PM" // 720 is noon in minutes
    var hours = minutesSinceMidnight / 60
    var minutes = (minutesSinceMidnight - hours * 60).toString

    if (hours > 12) {
      hours -= 12
    }

    if (minutes.length < 2) {
      minutes = "0" + minutes
    }

    s"$hours:$minutes $ampm"
  }
}

