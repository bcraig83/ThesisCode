/*
 * Copyright 2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package csv.yellowpages;

import java.util.Date;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;
import org.jsefa.csv.annotation.CsvSubRecord;

/**
 * DTO describing an employee.
 * 
 * @author Norman Lahme-Huetig
 * 
 */
@CsvDataType(defaultPrefix = "EMP")
public class Employee {
    @CsvField(pos = 1)
    String name;

    @CsvField(pos = 2)
    Role role;

    @CsvField(pos = 3)
    boolean executive = false;

    @CsvField(pos = 4, format = "dd.MM.yyyy")
    Date birthDate;

    @CsvSubRecord(pos = 5, prefix = "SCO")
    Score score;
}
