package com.cakefuelled.strider.organisation;

import com.cakefuelled.strider.user.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;

public interface OrganisationDAO {

    @SqlUpdate("CREATE TABLE Organisation (" +
            "id INTEGER PRIMARY KEY, " +
            "path VARCHAR(32) NOT NULL," +
            "name VARCHAR(32) NOT NULL," +
            "domain VARCHAR(32) NOT NULL) ")
    void createOrganisationTable();

    @SqlQuery("SELECT * FROM Organisation")
    List<Organisation> query();

    @SqlQuery("SELECT Organisation.id FROM Organisations " +
            "INNER JOIN UserOrganisation " +
            "ON Organisation.id = UserOrganisation.organisationId " +
            "WHERE UserOrganisation.userId = userId")
    List<Organisation> getOrganisationsByUser(@Bind("userId") int userId);
}
