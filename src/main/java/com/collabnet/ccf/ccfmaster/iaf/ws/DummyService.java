package com.collabnet.ccf.ccfmaster.iaf.ws;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.collabnet.ce.soap50.integratedapps.util.IntegratedAppSupport;
import com.vasoftware.sf.server.common.pluggable.IntegratedAppConfig;
import com.vasoftware.sf.server.common.pluggable.IntegratedAppConfigParamDO;

public class DummyService {
    public void createProjectConfig(IntegratedAppConfig iaConfig) throws RemoteException {
            return;
    }

    /**
     * Return the Project Configuration Parameters for this project
     * @param projectId Project for which configuration parameters are required
     * @return an array of ConfigParamDO Objects
     * @throws RemoteException if something went wrong
     */
    public IntegratedAppConfigParamDO[] getConfigurationParameters(String projectId)
            throws RemoteException {
    	System.out.println("called getConfigurationParameters("+projectId+")");
    	System.out.println("getConfigurationParameters: returning empty array.");
    	IntegratedAppConfigParamDO iaConfigParam = new IntegratedAppConfigParamDO();
    	return new IntegratedAppConfigParamDO[] {};
    }

    /**
     * Called when Integrated app is edited for a TeamForge project
     * @param iaConfig
     * @return
     * @throws RemoteException
     */
    public void editProjectConfig(IntegratedAppConfig iaConfig) throws RemoteException {
    	System.out.println("called editProjectConfig(IntegratedAppConfig), doing nothing.");
    	return;
    }

    /**
     * Remove an Integration from a CTF Project
     * @param iaConfig IntegratedAppConfig Object that contains info about user and project
     * @throws RemoteException if something goes wrong when adding
     */
    public void deleteProjectConfig(IntegratedAppConfig iaConfig) throws RemoteException {
    	System.out.println("called deleteProjectConfig(IntegratedAppConfig), doing nothing.");
    	return;
    }

    /**
      * Method to retrieve CTF ProjectId given an object id. Snce Pebble has per project id, this method can return
     * null;
      *
      * @param objectId Pebble Blog Id
      * @return String containing the CTF Project Id
      */
    public String findProjectIdForObject(String objectId) throws RemoteException {
    	System.out.println("called findProjectIdForObject("+objectId+")");
    	System.out.println("findProjectIdForObject: returning null.");
        return null;
    }

    /**
     * Returns the object Title by passing the objectId. for Pebble, we are just going
     * to return "Blog entries for <date passed>"
     * @param objectId
     *            the objectId
     * @return the object title
     */
    public String getObjectTitle(String objectId) throws RemoteException {
    	System.out.println("called getObjectTitle("+objectId+")");
    	String ret = "DUMMY OBJECT TITLE " + objectId;
    	System.out.println("returning "+ret);
    	return ret;
    }

    /**
     * Called when a CTF template is created. This is needed for those integrated applications that
     * need to do something special when a template is created. Note that initializeProject will anyway get called
     * during Project Creation, so this can only deal with Integrated app specific configuration
     *
     * @param sourceProjectId ProjectId of the source project
     * @param templateId ProjectId for the template
     * @param templateName The name of the template
     * @param creatorId The person creating the template
     * @return whether there was any issue creating the template.
     * @throws RemoteException
     */
    public void createTemplate(String sourceProjectId, String templateId, String templateName, String creatorId) throws RemoteException {
    	System.out.printf("called createTemplate(%s, %s, %s, %s), doing nothing.", sourceProjectId, templateId, templateName, creatorId);
    	return;
    }

    /**
     * Get the List of Contents which will be included in Templates. This is a descriptive information to the end
     * user and is shown in the "Create Template" screen for a project in CTF
     * @return Detail Map Containing the ContentType as Key empty ArrayList as value
     * @throws RemoteException
     */
    public Map getTemplateMetadata(String locale) throws RemoteException { 
    	System.out.printf("called getTemplateMetadata(%s)", locale);
        HashMap contentTypes = new HashMap();
        //contentTypes.put("Blog Configuration", new ArrayList());
        System.out.printf("getTemplateMetadata: returning empty map");
        return contentTypes;
    }

    /**
     * Get a detailed list of what got stored in a template, If you have some specific details , like object names that
     * were stored as part of template, this method can indicate those.
     *
     * Called as part of "View Template" screen in CTF.
     *
     * @param tmplName Template For which the View operation is performed
     * @return Map containing the Type of detail that gets stored along with individual object information that got stored.
     * @throws RemoteException
     */
    public Map getTemplateContent(String templateName, String locale) throws RemoteException {
    	System.out.printf("called getTemplateContent(%s, %s)", templateName, locale);
        return getTemplateMetadata(null);
    }

    /**
     * Called during a Create Project Call from Template. If the Integrated application needs some special configuration
     * that needs to be processed as part of creating a project from template, the "snippet" information in the XML
     * gets displayed to the user. These values are passed into this method as part of requestMap, so any validations
     * that need to be done by the integrated app for those parameters can happen here.
     *
     * @param iaConfig The IntegratedAppConfig  object containing project information
     * @param requestMap HashMap containing the key and value for the parameters used during Project Creation
     * @throws RemoteException
     */
    public void validateParametersForTemplatizedProject(IntegratedAppConfig iaConfig, 
            Map projectConfigurationParameters) throws RemoteException {
        // Dont need to do anything as we are not expecting any parameters
    	System.out.printf("called validateParametersForTemplatizedProject(IntegratedAppConfig, %s), doing nothing.", projectConfigurationParameters);
    }

    /**
     * This is equivalent to the "initializeProject" call in that when a project is created from a template, this
     * method is called.
     *
     * @param iaConfig The IntegratedAppConfig object
     * @param templateId The templateId from which the project should be created
     * @param title Title for the new project
     * @throws RemoteException
     */
    public void createTemplatizedProjectConfig(IntegratedAppConfig iaConfig, String templateId, String title) throws RemoteException {
    	System.out.printf("called createTemplatizedProject(IntegratedAppConfig, %s, %s), doing nothing.", templateId, title);
    	return;
    }


//    /**
//     * Returns the integratedAppSupport
//     * @return appSupport object
//     */
//    private IntegratedAppSupport getIntegratedAppSupport() {
//        MessageContext context = MessageContext.getCurrentContext();
//        HttpServlet servlet = (HttpServlet) context.getProperty(HTTPConstants.MC_HTTP_SERVLET);
//        IntegratedAppSupport appSupport = new IntegratedAppSupport(
//                        servlet.getInitParameter("ctfbaseurl"),
//                        servlet.getInitParameter("pebblebaseurl"),
//                        servlet.getInitParameter("appname"));
//        return appSupport;
//    }

    /**
     * Returns the soap session id by passing the oneTimeToken
     *
     * @param oneTimeToken
     * @param iAppSupport
     * @return soap sessionID
     */
    public String getSoapSessionId(String oneTimeToken, IntegratedAppSupport iAppSupport)
        throws RemoteException {
    	System.out.printf("called getSoapSessionId(%s, IntegratedAppSupport ias)", oneTimeToken);
        String soapSessionId = null;
        if (iAppSupport != null) {
            try {
                soapSessionId = iAppSupport.getCollabNetSoap().getWebAndSoapSessionId(oneTimeToken);
                String id[] = soapSessionId.split("&");
                soapSessionId = id[1];
            } catch (Exception e) {
                throw new RemoteException("Cannot get Session");
            }
        }
        System.out.println("getSoapSessionId: returning " + soapSessionId);
        return soapSessionId;
    }

}
