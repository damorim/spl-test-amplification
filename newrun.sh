#!/bin/bash

if [[ -z $CURDIR ]];
then
    echo "could not locate subject directory. please, define variable CURDIR."
    exit;
fi

####### bound for test generation
NUM_VALID_CONFIGURATIONS_FOR_TG=1
####### bound for test execution
NUM_RANDOM_CONFIGURATIONS_FOR_TE=1

source common

TIMESTAMP=`date +"%Y-%m-%d-%Hh%Mm"`
BINDIR=$CURDIR/bin

############################################
## generate different sets of configurations
## from all-configurations.txt:
##   twise, random, and all-shuffled
############################################
./gen-twise-and-random $CURDIR

javac -cp ${JUNIT} ${JAVASCRIPTSDIR}/MyTestRunner.java


    date
    
) 2>&1 | tee "${CURDIR}/log-${TIMESTAMP}.txt"

