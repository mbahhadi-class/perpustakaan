package id.starter.perustakaan.controller;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@PreAuthorize("isFullyAuthenticated()")
public abstract class BaseController {

}
