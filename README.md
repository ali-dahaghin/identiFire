# identiFire
Id Generator toolkit- an Object oriented way for generate ids.

## simple usage
```java
List<FormatElement> formatElements = new ArrayList<FormatElement>();
formatElements.add(new UpperCaseFormatElement());
formatElements.add(new LowerCaseFormatElement());
formatElements.add(new IntegerFormatElement());formatElements.add(new IntegerFormatElement());
formatElements.add(new ParameterFormatElement("firstKey"));
formatElements.add(new IntegerFormatElement());
IdFire idFire = new FormattedIdFire(new SetStorage(), formatElements);

Options options = Options.getEmpty();
options.setParam("firstKey", "_A10_");
System.out.println(idFire.generate(options));
System.out.println(idFire.generate(options));
System.out.println(idFire.generate(options));
System.out.println(idFire.generate(options));
System.out.println(idFire.generate(options));
System.out.println(idFire.generate(options));
System.out.println(idFire.generate(options));
```
### output:
```
Mu83_A10_0
Ju55_A10_7
Hx65_A10_7
Az23_A10_9
Cr30_A10_6
Iz06_A10_3
Jm89_A10_2
```
