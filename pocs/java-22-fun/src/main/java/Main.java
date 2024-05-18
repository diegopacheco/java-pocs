import com.github.diegopacheco.jeps.*;

// 463: Implicitly Declared Classes and Instance Main Methods (Second Preview)
//
// To run on IntelliJ idea need to add VM Options: --add-modules jdk.incubator.vector
//
void main(){
    UnnamedVariablePatterns.run();
    StringTemplates.run();
    StreamGatherers.run();
    StatementBeforeSuper.run();
    ClassFileAPI.run();
    VectorApi.run();
}
