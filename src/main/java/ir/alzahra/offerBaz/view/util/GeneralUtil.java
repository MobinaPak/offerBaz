package ir.alzahra.offerBaz.view.util;

import org.primefaces.context.RequestContext;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author z.moafi
 * @since 31/08/2019
 */
public class GeneralUtil {


    public static void openWindow(String viewPath, Object[] attributes, String parameterObjectTitle, Object windowInputObjectParameter, String windowInputObjectParameterPrefixName){

        String uniqueId = GeneralUtil.addObjectToObjectRepository(FacesContext.getCurrentInstance(), windowInputObjectParameterPrefixName, windowInputObjectParameter);
        RequestContext requestContext = RequestContext.getCurrentInstance();

        Map<String, Object> options = new HashMap<>();

        if (attributes != null) {


            if (attributes[0] != null) {
                options.put("modal", (boolean) attributes[0]);
            }

            if (attributes[1] != null) {
                options.put("width", (String) attributes[1]);
            }

            if (attributes[3] != null) {
                options.put("contentWidth", (String) attributes[3]);
            }

            options.put("closable", true);


            if (attributes[6] != null) {
                options.put("resizable", (boolean) attributes[6]);
            }
        }
        List<String> ids = new ArrayList<>();
        ids.add(uniqueId);
        Map<String, List<String>> params = new HashMap<>();
        params.put(parameterObjectTitle, ids);

        requestContext.openDialog(viewPath, options, params);
    }

    private static String addObjectToObjectRepository(FacesContext facesContext, String prefix, Object object) {
        String uniqueId = GeneralUtil.getUniqueId(facesContext, prefix);
        GeneralUtil.setObjectIntoApplicationMap(FacesContext.getCurrentInstance(), uniqueId, object);
        return uniqueId;
    }

    private static String getUniqueId(FacesContext facesContext, String prefix) {
        long time = new Date().getTime();
        int randomNum = generateRandomNumber();
        return prefix + "_" + getClientIpAddress(facesContext) + "_" + String.valueOf(time) + "_" + String.valueOf(randomNum);
    }

    public static int generateRandomNumber() {
        int min = 100;
        int max = 999;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    public static String getClientIpAddress(FacesContext facesContext) {
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
    public static void setObjectIntoApplicationMap(FacesContext facesContext, String id, Object value) {
        facesContext.getExternalContext().getApplicationMap().put(id, value);
    }


    public static Object getAndRemoveObjectFromObjectRepository(FacesContext facesContext, String objectTitle) {
        String editedObjectId = getObjectId(facesContext, objectTitle);
        return getAndRemoveObjectFromAplicationMap(facesContext, editedObjectId);
    }
    public static String getObjectId(FacesContext facesContext, String objectTitle) {
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        return request.getParameter(objectTitle);
    }
    public static Object getAndRemoveObjectFromAplicationMap(FacesContext facesContext, String id) {
        Object retObj = null;
        if (id != null) {
            if (facesContext.getExternalContext().getApplicationMap().containsKey(id)) {
                retObj = facesContext.getExternalContext().getApplicationMap().get(id);
                facesContext.getExternalContext().getApplicationMap().remove(id);
            }
        }
        return retObj;
    }

}
