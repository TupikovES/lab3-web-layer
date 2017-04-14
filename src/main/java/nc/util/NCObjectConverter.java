package nc.util;

import nc.entity.*;
import nc.entity.impl.ClubImpl;
import nc.entity.impl.NCObjectImpl;
import nc.entity.impl.NCParamImpl;
import nc.util.batchsqlquery.BatchSqlCreatorContext;
import nc.util.batchsqlquery.impl.ClubBatchSqlCreator;
import nc.util.batchsqlquery.impl.DivisionBatchSqlCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by petka on 28.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public final class NCObjectConverter {

    public static final String CLUB_TYPE_ID = "0bbfc4e4-10b9-11e7-83f0-b888e3a0097b";
    public static final String DIVISION_TYPE_ID = "0be36ff0-10b9-11e7-83f0-b888e3a0097b";
    public static final String PLAYER_TYPE_ID = "0be38f6b-10b9-11e7-83f0-b888e3a0097b";

    public static NCObject toNCObject(Club club) {
        NCObject ncObject = new NCObjectImpl();
        ncObject.setObjectId(club.getId() == null ? null : club.getId());
        ncObject.setObjectType(CLUB_TYPE_ID);
        ncObject.setObjectName(club.getName());
        List<NCParam> paramList = new ArrayList<>();
        paramList.add(new NCParamImpl("ad184d56-10b9-11e7-83f0-b888e3a0097b", club.getName()));
        paramList.add(new NCParamImpl("ad18652a-10b9-11e7-83f0-b888e3a0097b", club.getCity()));
        ncObject.setParams(paramList);
        ncObject.setContext(new ClubBatchSqlCreator());
        return ncObject;
    }

    public static NCObject toNCObject(Division division) {
        NCObject ncObject = new NCObjectImpl();
        ncObject.setObjectId(division.getId() == null ? null : division.getId());
        ncObject.setObjectType(DIVISION_TYPE_ID);
        ncObject.setObjectName(division.getName());
        List<NCParam> paramList = new ArrayList<>();
        paramList.add(new NCParamImpl("ad186ff1-10b9-11e7-83f0-b888e3a0097b", division.getName()));
        ncObject.setParams(paramList);
        ncObject.setContext(new ClubBatchSqlCreator());
        return ncObject;
    }

    public static NCObject toNCObject(Player player) {
        return null;
    }

    public static Club toClub(NCObject ncObject){
        Club club = new ClubImpl();

        club.setId(ncObject.getObjectId());
        club.setName(ncObject.getObjectName());
        if (!ncObject.getValues().isEmpty()) {
            for (Map.Entry<NCAttribute, NCParam> map : ncObject.getValues().entrySet()) {
                NCAttribute attribute = map.getKey();
                if (attribute.getAttributeName().equals("City")) {
                    club.setCity(map.getValue().getStringValue());
                }
            }
        }
        return club;
    }
}