package com.thoughtmechanix.organization.controllers;


import com.thoughtmechanix.organization.exception.ResourceNotFoundException;
import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.services.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationServiceController {
    @Autowired
    private OrganizationService orgService;

    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceController.class);

	/**
	 * Get organization by organization id
	 * Using @PathVariable organizationId
	 * @throws ResourceNotFoundException 
	 */
    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    public Organization getOrganization( @PathVariable("organizationId") String organizationId) throws ResourceNotFoundException {
        logger.debug("Looking up data for org {}",organizationId);

        Organization org = orgService.getOrg(organizationId);
        org.setContactName( "NEW::" + org.getContactName() );
        return org;
    }

	/**
	 * POST organization
	 * Using @RequestBody organization
	 */
    @RequestMapping(value="/{organizationId}",method = RequestMethod.POST)
    public void saveOrganization(@RequestBody Organization org) {
		logger.info("Adding organization with: {}", org);
		orgService.saveOrg( org );
    }

	/**
	 * PUT organization by organization id
	 * Using @PathVariable organizationId
	 * Using @RequestBody organization
	 * @throws ResourceNotFoundException
	 */
    @RequestMapping(value="/{organizationId}",method = RequestMethod.PUT)
    public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization org) 
			throws ResourceNotFoundException {
		logger.info("Updating organization: {} with id: {}", org, orgId);
		orgService.updateOrg(orgId, org);
    }

	/**
	 * DELETE organization by organization id
	 * Using @PathVariable organizationId
	 * @throws ResourceNotFoundException
	 */
    @RequestMapping(value="/{organizationId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteOrganization(@PathVariable("organizationId") String orgId) throws ResourceNotFoundException {
		orgService.deleteOrg( orgId );
		return HttpStatus.OK.toString();
    }

}

