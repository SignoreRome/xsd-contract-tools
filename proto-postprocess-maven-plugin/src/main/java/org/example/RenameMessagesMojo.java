package org.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "rename-messages")
public class RenameMessagesMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("proto-postprocess:rename-messages works (stub).");
    }

}
