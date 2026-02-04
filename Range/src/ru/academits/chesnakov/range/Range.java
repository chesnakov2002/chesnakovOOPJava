package ru.academits.chesnakov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Range{" + "from = " + from + ", to = " + to + '}';
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getRangeLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        if (number >= from) {
            return number <= to;
        }

        return false;
    }

    public Range getIntersection(Range range) {
        if (this.getTo() <= range.getFrom() || this.getFrom() >= range.getTo()) {
            return null;
        }

        double maxFrom = Math.max(this.getFrom(), range.getFrom());
        double minTo = Math.min(this.getTo(), range.getTo());

        return new Range(maxFrom, minTo);
    }

    public Range[] getUnion(Range range) {
        if (this.getTo() < range.getFrom() || this.getFrom() > range.getTo()) {
            return new Range[]{new Range(this.getFrom(), this.getTo()), new Range(range.getFrom(), range.getTo())};
        }

        double minFrom = Math.min(this.getFrom(), range.getFrom());
        double maxTo = Math.max(this.getTo(), range.getTo());

        return new Range[]{new Range(minFrom, maxTo)};
    }

    public Range[] getDifference(Range range) {
        if (this.getIntersection(range) == null) {
            return new Range[]{this};
        }

        if (this.getFrom() >= range.getFrom() && this.getTo() <= range.getTo()) {
            return new Range[]{};
        }

        if (this.getFrom() >= range.getFrom() && this.getTo() > range.getTo()) {
            return new Range[]{new Range(range.getTo(), this.getTo())};
        }

        if (this.getFrom() < range.getFrom() && this.getTo() <= range.getTo()) {
            return new Range[]{new Range(this.getFrom(), range.getFrom())};
        }

        Range intersectionRange = this.getIntersection(range);

        return new Range[]{new Range(this.getFrom(), intersectionRange.getFrom()), new Range(intersectionRange.getTo(), this.getTo())};
    }
}