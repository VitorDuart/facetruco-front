package com.utfpr.facetruco.util;


import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.utfpr.facetruco.beans.UserBean;
import com.utfpr.facetruco.pojo.Mes;

@FacesConverter(value = "mesConverter")
public class MesConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{userBean}", UserBean.class);

        UserBean users = (UserBean)vex.getValue(ctx.getELContext());
        return users.getMes(Integer.valueOf(beerId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
        Mes mes = (Mes)obj;
        return mes.getId().toString();
    }

}