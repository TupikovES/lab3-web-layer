package nc.util;

import nc.entity.*;
import nc.entity.impl.*;
import nc.util.batchsqlquery.BatchSqlCreatorContext;
import nc.util.batchsqlquery.impl.ClubBatchSqlCreator;
import nc.util.batchsqlquery.impl.DivisionBatchSqlCreator;
import nc.util.batchsqlquery.impl.PlayerBatchSqlCreator;

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
        NCObject ncObject = new NCObjectImpl();
        ncObject.setObjectId(player.getId() == null ? null : player.getId());
        ncObject.setObjectType(PLAYER_TYPE_ID);
        ncObject.setObjectName(player.getLastName());
        List<NCParam> paramList = new ArrayList<>();
        paramList.add(new NCParamImpl("ad2b074c-10b9-11e7-83f0-b888e3a0097b", player.getFirstName()));
        paramList.add(new NCParamImpl("ad2b22cd-10b9-11e7-83f0-b888e3a0097b", player.getLastName()));
        paramList.add(new NCParamImpl("ad2b3a78-10b9-11e7-83f0-b888e3a0097b", player.getAge()));
        ncObject.setParams(paramList);
        ncObject.setContext(new PlayerBatchSqlCreator());
        return ncObject;
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

    public static Division toDivision(NCObject ncObject) {
        Division division = new DivisionImpl();
        division.setId(ncObject.getObjectId());
        division.setName(ncObject.getObjectName());
        return division;
    }

    public static Player toPlayer(NCObject ncObject) {
        Player player = new PlayerImpl();
        player.setId(ncObject.getObjectId());
        if (!ncObject.getValues().isEmpty()) {
            for (Map.Entry<NCAttribute, NCParam> map :
                 ncObject.getValues().entrySet()) {
                switch (map.getKey().getAttributeName()) {
                    case "First Name":
                        player.setFirstName(map.getValue().getStringValue());
                        break;
                    case "Last Name":
                        player.setLastName(map.getValue().getStringValue());
                        break;
                    case "Age":
                        player.setAge(map.getValue().getNumberValue());
                        break;
                    default:
                        break;
                }
            }
        }
        return player;
    }
}
