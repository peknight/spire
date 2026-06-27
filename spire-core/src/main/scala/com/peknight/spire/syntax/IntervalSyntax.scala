package com.peknight.spire.syntax

import cats.kernel.Order
import bound.fromOption
import com.peknight.spire.math.interval.IntervalOps
import com.peknight.spire.math.interval.time.LocalDateIntervalOps
import spire.math.Interval
import spire.math.interval.Bound

import java.time.{LocalDate, Year}

trait IntervalSyntax:
  extension [N: {Integral, Order}] (interval: Interval[N])
    def close: Interval[N] = IntervalOps.close(interval)
  end extension

  extension (date: Interval[LocalDate])
    def mapToYear: Interval[Year] = LocalDateIntervalOps.mapToYear(date)
    def close: Interval[LocalDate] = IntervalOps.close(date)
  end extension

  extension (interval: Interval.type)
    def fromOptions[A: Order](lower: Option[A] = None, upper: Option[A] = None,
                              openLower: Boolean = false, openUpper: Boolean = true): Interval[A] =
      Interval.fromBounds(Bound.fromOption(lower, openLower), Bound.fromOption(upper, openUpper))
  end extension
end IntervalSyntax
object IntervalSyntax extends IntervalSyntax
