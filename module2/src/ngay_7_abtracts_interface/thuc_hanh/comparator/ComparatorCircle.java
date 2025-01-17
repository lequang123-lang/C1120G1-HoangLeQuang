package ngay_7_abtracts_interface.thuc_hanh.comparator;

import ngay_6_ke_thua.thuc_hanh.Circle;
import java.util.Comparator;

public class ComparatorCircle implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) {
            return 1;
        } else if (c1.getRadius() < c2.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
