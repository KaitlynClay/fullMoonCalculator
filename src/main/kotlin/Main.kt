import java.time.format.DateTimeFormatter
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun main(args: Array<String>) {
    // getting the current date, formatting it, and printing out the results
    val current = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val formCurrent = current.format(formatter)
    val nextFullMoon = calcNextFullMoon(current)
    val nextFullFomatted = nextFullMoon.format(formatter)
    println("The current date is $formCurrent")
    println("The next full moon is on $nextFullFomatted")
}

fun calcNextFullMoon(currentDate: LocalDate): LocalDate {
    // taking the date of the last full moon and calculating the next full moon, passing it to the main func
    val daysToNextFullMoon = 29.5
    val daysSinceLastFullMoon = ChronoUnit.DAYS.between(LocalDate.of(2023, 8, 30), currentDate)
    val daysToNextFullMoonRounded = daysToNextFullMoon - (daysSinceLastFullMoon % daysToNextFullMoon)
    return currentDate.plusDays(daysToNextFullMoonRounded.toLong())
}