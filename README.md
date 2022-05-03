# RefactoringTool

The aim of this project is to build an Engine to create automatic
metamodel adapters for users editors and relatives model back trasformations
to update original domain models.


## Folders

**/repository** : contains the Abstract Transformation Rules for models/metamodels transformations.

**/engine**: contains the software engine which makes the abstract rules concrete.

**/input** : contains input models and metamodels.

**/output** : contains artifact produced by the tool suite itself.

**/templates** : contains templates file to create new evolution/de-evolution pair of rules.


## Technologies

It has been used the [Epsilon Framework](https://www.eclipse.org/epsilon/ "Epsilon Framework"):

* _EGL_: It is used to define abstract rules that realize metamodel evolution and model de-evolution.
* _EGX_: EGL coordinator, it is used to instanciate the EGL abstract rules into the effective
ETL transformations.
* _EOL_: Realizes utility functions that are imported in other modules.
* _ETL_: Automatic generated transformations which apply evolution and de-evolution on input
models and metamodels.


## Run
### with configuration
Import the configuration in Eclipse environment and run it:

```
/launch
```

### without configuration (Standalone Java Class)
Right click -> Run As Java Application in the project:

```
 EGXStandalone.java
```

### execution flow
Source Domain example metamodel: example1_Domain.ecore
Target Domain example metamodel (generated): refactoredMM.ecore

Source Domain example model for Subclass (generated): Subclass_domain.xmi
Source Domain example model for Rotation (generated): Rotation_domain.xmi

Target Domain example model for Subclass (user edited): Subclass.xmi
Target Domain example model for Rotation (user edited): Rotation.xmi

####Step 1: BINDING
> binder (binder.egx)

First of all this operation is needed in order to instanciate the Abstract Rules defined
in the repository to the actual instances of used Metamodels (and corresponding Models).
When launched the binder module for each repository rule ask the user to specify to which
metaclasses it has to be applied on.
Each rule can be applied to 0..n Metaclasses.
For now, each execution can involve one and only one Evolution Rule.

####Step 2: Metamodel evolution
> testEvolution (evolveMetamodels.etl)

The previous step configured ETL transformation to evolve Metamodels and de-evolve corresponding
Models. At this second step the evolving transformation is applied on the Metamodel to generate
the target one. The resulting target metamodel can be then used by user to edit conformed models. 

####Step 3: Model de-evolution
> testDeSubclass (evolveModels.etl)
> testDeRotation (evolveModels.etl)

This last step is used to de-evolve user-edited model into the source domain model. This
transformation has already been configured in the binding step. Running it, the target-conform model
is automatically transformed in a source-conform model.


### future works
The execution flow is embedded in the eclipse IDE as a plugin, in order to improve user
usability. The binding step will be invoked by user and then applies directly the metamodel
evolution.
Instead, the model de-evolution will be automatically applied when user will save the
target-conform model instance, generating a source-conform model instance.
More than one rule could be applied in each one iteration.

## Credits

@copyright 2019
