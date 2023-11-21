import static globals.Globals.*

BR = recipemap('batch_reactor')
LCR = recipemap('large_chemical_reactor')
FBR = recipemap('fixed_bed_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')

// Terephthaloyl chloride
BR.recipeBuilder()
    .inputs(ore('dustTerephthalicAcid') * 3)
    .fluidInputs(fluid('bistrichloromethylbenzene') * 1000)
    .outputs(metaitem('dustTerephthaloylChloride') * 6)
    .fluidOutputs(fluid('hydrogen_chloride') * 2000)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

// Kevlar
CSTR.recipeBuilder()
    .fluidInputs(fluid('acetylene') * 50)
    .fluidInputs(fluid('formaldehyde') * 100)
    .fluidOutputs(fluid('butanediol') * 50)
    .EUt(120)
    .duration(4)
    .buildAndRegister()

FBR.recipeBuilder()
    .fluidInputs(fluid('butanediol') * 50)
    .notConsumable(metaitem('catalystBedCopper'))
    .fluidOutputs(fluid('gamma_butyrolactone') * 50)
    .fluidOutputs(fluid('hydrogen') * 200)
    .EUt(120)
    .duration(4)
    .buildAndRegister()

LCR.recipeBuilder()
    .notConsumable(metaitem('dustCalciumChloride') * 1)
    .inputs(ore('dustParaPhenylenediamine') * 8)
    .inputs(ore('dustTerephthaloylChloride') * 3)
    .notConsumable(fluid('n_methyl_ii_pyrrolidone') * 100)
    .fluidInputs(fluid('sulfuric_acid') * 500)
    .outputs(metaitem('dustKevlar') * 4)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .EUt(1920)
    .duration(300)
    .buildAndRegister()
