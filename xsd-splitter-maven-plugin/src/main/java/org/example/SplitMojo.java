package org.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "split")
public class SplitMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("xsd-splitter:split works (stub).");
    }

}