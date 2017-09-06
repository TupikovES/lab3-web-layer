package nc.util;

import nc.entity.ObjectEntity;

/**
 * Created by x3mib on 16.07.2017.
 */
public class Breadcrumb {

    private StringBuilder breadcrumb;

    public Breadcrumb() {
        breadcrumb = new StringBuilder();
    }

    public String createBreadcrumb(ObjectEntity objectEntity) {

        breadcrumb.append("<ol class=\"breadcrumb\"><li><a href=\"/Lab3/division/views/");
        breadcrumb.append(objectEntity.getParent().getId());
        breadcrumb.append("\">");
        breadcrumb.append(objectEntity.getParent().getName());
        breadcrumb.append("</a></li><li class\"active\">");
        breadcrumb.append(objectEntity.getName());
        breadcrumb.append("</li></ol>");

        return breadcrumb.toString();
    }

    public StringBuilder getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(StringBuilder breadcrumb) {
        this.breadcrumb = breadcrumb;
    }
}
