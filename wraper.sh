#!/bin/bash

##creating subject dirs
SUBJECTS_DIR="$BASEDIR/src-subjects"
BERKELEY_DB="BerkeleyDb"
SUDOKU="Sudoku"
GPL="GPL"
PREVAYLER="Prevayler"
101COMPANIES="101Companies"
ZIPME="ZipMe"
JTOPAS="JTopas"

##BERKELEY_DB
(cd $SUBJECTS_DIR/$BERKELEY_DB;
    ./s
)

##SUDOKU
(cd $SUBJECTS_DIR/$SUDOKU;
    ./s
)

##GPL
(cd $SUBJECTS_DIR/$GPL;
    ./s
)

##PREVAYLER
(cd $SUBJECTS_DIR/$PREVAYLER;
    ./s
)

##101COMPANIES
(cd $SUBJECTS_DIR/$101COMPANIES;
    ./s
)

##ZIPME
(cd $SUBJECTS_DIR/$ZIPME;
    ./s
)

##ZIPME
(cd $SUBJECTS_DIR/$ZIPME;
    ./s
)

##JTOPAS
(cd $SUBJECTS_DIR/$JTOPAS;
    ./s
)