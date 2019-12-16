package xupt.se.ttms.dao;

import java.util.List;

import xupt.se.ttms.domain.Plan;

public interface IplanDao {
    int planInsert(Plan plan);

    int planDelete(int plan_id);

    int planUpdate(Plan plan);

    List<Plan> getPlanAll();
}
