

package entity;

import enums.Subject;
import exceptions.MarkOutOfBoundsException;

public class Mark {
    private static int n = 0;
    private Subject subject;
    private int mark;

    public Mark(Subject subject, int mark) throws MarkOutOfBoundsException {
        if (mark >= 0 & mark <= 10) {
            this.subject = subject;
            this.mark = mark;
        } else {
            throw new MarkOutOfBoundsException("The mark is not valid");
        }
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
