import java.util.*;

class Polygon {
    private final LinkedHashSet<Line> polygon;
    private int objID;
    private static int classID;
    Iterator<Line> it;

    public Polygon(LinkedHashSet<Line> polygon) {
        this.polygon = new LinkedHashSet<Line>();

        // becomes aggregation now
        for (Line l : polygon)
            this.polygon.add(l);

        objID = ++classID;
        it = this.polygon.iterator();
    }

    public Iterator<Line> getLine() {
        it = polygon.iterator();
        return it;
    }

    public static int classID() {
        return classID;
    }

    public String toString() {
        // THIS METHOD DOESN'T WORK. AS PART OF EXERCISE-2 STUDENTS MUST FIX
        // IT TO RETURN A STRING WITH THE INFORMATION ABOUT START AND END
        // POINTS OF N LINES OF A POLYGON. AS SHOWN IN THE EXAMPLE BELOW:
        // The lines in polygon 1 are:
        // Line 1: starts at (20, 30), and ends at (50, 100)
        // Line 2: starts at (50, 100), and ends at (100, 30)
        // Line 3: starts at (100, 30), and ends at (20, 30)
        //
        String s = "";

        Iterator i = this.getLine();

        if(i.hasNext()) {
            s += String.format("The lines in polygon %d are:", classID);
        }

        while(i.hasNext()) {
            s += String.format("%n ");
            s += i.next();
        }

        return s;
    }
}
