package com.collabnet.ccf.ccfmaster.iaf.ws;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.collabnet.ce.soap50.integratedapps.util.IntegratedAppSupport;
import com.vasoftware.sf.server.apps.search.SearchInfo;
import com.vasoftware.sf.server.common.pluggable.IntegratedAppConfig;
import com.vasoftware.sf.server.common.pluggable.IntegratedAppConfigParamDO;

public class DummyService61 {

	/**
	 * Method thatd be called when an integrated app is added to a Teamforge project
	 * @param oneTimeToken
	 * @param iaConfig IntegratedAppConfig Object that contains info about user and project
	 * @throws RemoteException if something goes wrong when adding
	 */
	public void createProjectConfig(String oneTimeToken, IntegratedAppConfig iaConfig) throws RemoteException {
		
	}

	/**
	 * Called when a CTF template is created. This is needed for those integrated applications that
	 * need to do something special when a template is created. Note that initializeProject will anyway get called
	 * during Project Creation, so this can only deal with Integrated app specific configuration
	 * @param oneTimeToken
	 * @param sourceProjectId ProjectId of the source project
	 * @param templateId ProjectId for the template
	 * @param templateName The name of the template
	 * @param creatorId The person creating the template
	 * @return whether there was any issue creating the template.
	 * @throws RemoteException
	 */
	public void createTemplate(String oneTimeToken, String sourceProjectId, String templateId, String templateName, String creatorId) throws RemoteException {
		
	}

	/**
	 * This is equivalent to the "initializeProject" call in that when a project is created from a template, this
	 * method is called.
	 * @param oneTimeToken
	 * @param iaConfig The IntegratedAppConfig object
	 * @param templateId The templateId from which the project should be created
	 * @param title Title for the new project
	 * @throws RemoteException
	 */
	public void createTemplatizedProjectConfig(String oneTimeToken, IntegratedAppConfig iaConfig, String templateId, String title) throws RemoteException {
		
	}

	/**
	 * Remove an Integration from a CTF Project
	 * @param oneTimeToken
	 * @param iaConfig IntegratedAppConfig Object that contains info about user and project
	 * @throws RemoteException if something goes wrong when adding
	 */
	public void deleteProjectConfig(String oneTimeToken, IntegratedAppConfig iaConfig) throws RemoteException {
		
	}

	/**
	 * Called when Integrated app is edited for a TeamForge project
	 * @param oneTimeToken
	 * @param iaConfig
	 * @return
	 * @throws RemoteException
	 */
	public void editProjectConfig(String oneTimeToken, IntegratedAppConfig iaConfig) throws RemoteException {
		
	}

	/**
	     * Method to retrieve CTF ProjectId given an object id. Snce Pebble has per project id, this method can return
	    * null;
	     *@param oneTimeToken
	     * @param objectId Pebble Blog Id
	     * @return String containing the CTF Project Id
	     */
	   public String findProjectIdForObject(String oneTimeToken, String objectId) throws RemoteException {
	       return null;
	   }

	/**
	 * Return the Project Configuration Parameters for this project
	 * @param oneTimeToken
	 * @param projectId Project for which configuration parameters are required
	 * @return an array of ConfigParamDO Objects
	 * @throws RemoteException if something went wrong
	 */
	public IntegratedAppConfigParamDO[] getConfigurationParameters(String oneTimeToken, String projectId)
	        throws RemoteException {
		return new IntegratedAppConfigParamDO[0];
	}

	/**
	 * Returns the object Title by passing the objectId. for Pebble, we are just going
	 * to return "Blog entries for <date passed>"
	 * @param oneTimeToken
	 * @param objectId
	 *            the objectId
	 * @return the object title
	 */
	public String getObjectTitle(String oneTimeToken, String objectId) throws RemoteException {
		System.out.println("called getObjectTitle("+oneTimeToken+", "+objectId+")");
		String ret = "DUMMY OBJECT TITLE " + objectId;
		System.out.println("returning "+ret);
		return ret;
	}

	/**
	 * The default value to be displayed when a page component for this integrated application
	 * is created. 
	 *
	 * For this example, the current date is returned and the page component will show the titles
	 * for the blogs published on this date.
	 *
	 * @param oneTimeToken One time login token
	 * @param projectId project id.
	 * @param locale requested locale.
	 * @return Default value that will be displayed on the page configuration screen
	 * @throws RemoteException thrown when an error occurs.
	 */
	public String[] getPageComponentParameters(String oneTimeToken, String projectId,
	                                    String locale)
	    throws RemoteException
	{
		return new String[0];
	}

	/**
	 * Get the Search Results by searching through all blogs. This looks through all blogs and figures the search results,
	 * converts them to hits and calls the IntegratedAppSearchResults bean to set the results
	 * @param oneTimeToken
	 * @param searchInfo Search information coming in from CTF with text to search
	 * @param rbacInfo  RBAC information with included single-signon token for making any soap calls
	 * @return XML formatted with search results
	 */
	public String getSearchResults(String oneTimeToken, SearchInfo searchInfo, String locale)
	    throws RemoteException {
		return "";
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

	/**
	 * Get a detailed list of what got stored in a template, If you have some specific details , like object names that
	 * were stored as part of template, this method can indicate those.
	 *
	 * Called as part of "View Template" screen in CTF.
	 * @param oneTimeToken
	 * @param tmplName Template For which the View operation is performed
	 * @return Map containing the Type of detail that gets stored along with individual object information that got stored.
	 * @throws RemoteException
	 */
	public Map getTemplateContent(String oneTimeToken, String templateName, String locale) throws RemoteException {
		return new HashMap();
	}

	/**
	 * Get the List of Contents which will be included in Templates. This is a descriptive information to the end
	 * user and is shown in the "Create Template" screen for a project in CTF
	 * @param oneTimeToken
	 * @param locale
	 * @return Detail Map Containing the ContentType as Key empty ArrayList as value
	 * @throws RemoteException
	 */
	public Map getTemplateMetadata(String oneTimeToken, String locale) throws RemoteException { 
		return new HashMap();
	}

	/**
	 * Called during a Create Project Call from Template. If the Integrated application needs some special configuration
	 * that needs to be processed as part of creating a project from template, the "snippet" information in the XML
	 * gets displayed to the user. These values are passed into this method as part of requestMap, so any validations
	 * that need to be done by the integrated app for those parameters can happen here.
	 * @param oneTimeToken
	 * @param iaConfig The IntegratedAppConfig  object containing project information
	 * @param requestMap HashMap containing the key and value for the parameters used during Project Creation
	 * @throws RemoteException
	 */
	public void validateParametersForTemplatizedProject(String oneTimeToken, IntegratedAppConfig iaConfig, 
	        Map projectConfigurationParameters) throws RemoteException {
	    // Dont need to do anything as we are not expecting any parameters
	}

}
