import org.scalatest._
import flatspec._
import matchers.should._

class TimeUtilsSpec extends AnyFlatSpec with Matchers {
  "addMinutes" should "add correctly" in {
    TimeUtils.addMinutes("9:13 AM", 30) should equal ("9:43 AM")
  }
  it should "handle going from AM to PM" in {
    TimeUtils.addMinutes("9:13 AM", 200) should equal ("12:33 PM")
  }
  it should "handle negative minutes" in {
    TimeUtils.addMinutes("9:13AM", -30) should equal ("8:43 AM")
  }
  it should "handle going from PM to AM" in {
    TimeUtils.addMinutes("1:00 PM", -70) should equal("11:50 AM")
  }
  it should "handle going to the next day" in {
    TimeUtils.addMinutes("11:00 AM", 870) should equal("1:30 AM")
  }
  it should "handle going to the previous day" in {
    TimeUtils.addMinutes("2:00 AM", -150) should equal("11:30 PM")
  }
  it should "handle adding up to midnight" in {
    TimeUtils.addMinutes("11:40 PM", 20) should equal("0:00 AM")
  }
  it should "handle going back to midnight" in {
    TimeUtils.addMinutes("1:20 PM", -800) should equal("0:00 AM")
  }
  it should "handle going forward multiple days" in {
    TimeUtils.addMinutes("1:20 PM", 4210) should equal("11:30 AM")
  }
  it should "handle going back multiple days" in {
    TimeUtils.addMinutes("1:20 PM", -2990) should equal("11:30 AM")
  }
}
