package com.tvarit.plugin;

import com.amazonaws.services.cloudformation.AmazonCloudFormationClient;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.tvarit.plugin.env.TvaritEnvironment;
import com.tvarit.plugin.vpc.MakeVpcDelegate;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.net.MalformedURLException;
import java.net.URL;

@Mojo(name = "make-vpc")
public class MakeVpcMojo extends AbstractMojo {

    @Parameter(required = true)
    private String projectName;
    @Parameter(required = true)
    private String domainName;
    @Parameter(required = true)
    private String bucketName;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        TvaritEnvironment tvaritEnvironment = TvaritEnvironment.init(this);
        new MakeVpcDelegate().make();
    }

    public String getProjectName() {
        return projectName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getDomainName() {
        return domainName;
    }
}
